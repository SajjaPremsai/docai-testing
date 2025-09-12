import requests
from utils.createJWT import create_jwt

def get_installation_token(installation_id: str, app_id: str) -> str:
    """
    Retrieves an installation access token for a GitHub App installation.

    This token is used to authenticate as a specific GitHub App installation
    and perform actions on behalf of that installation (e.g., accessing repositories
    or user data that the app has permission for).

    Args:
        installation_id (str): The ID of the GitHub App installation. This identifies
                                the specific repository or organization where the app
                                is installed.
        app_id (str): The ID of your GitHub App. This is used by `create_jwt`
                      to generate the JSON Web Token.

    Returns:
        str: The installation access token. This token is short-lived (typically 1 hour)
             and should be used for subsequent API calls that require installation
             authentication.

    Raises:
        requests.exceptions.RequestException: If the API request fails (e.g.,
                                              network error, non-2xx status code).
        KeyError: If the 'token' key is not present in the successful JSON response.
    """
    # 1. Generate a JSON Web Token (JWT) for the GitHub App.
    # This JWT authenticates the GitHub App itself and is required to request
    # an installation access token. It's signed with the app's private key.
    jwt_token = create_jwt(app_id)

    # 2. Construct the API endpoint URL for requesting an installation access token.
    # This URL targets the specific installation identified by `installation_id`.
    url = f"https://api.github.com/app/installations/{installation_id}/access_tokens"

    # 3. Prepare the request headers.
    # - "Authorization": Uses the generated JWT prefixed with "Bearer".
    # - "Accept": Specifies the GitHub API version and format (recommended).
    headers = {
        "Authorization": f"Bearer {jwt_token}",
        "Accept": "application/vnd.github+json"
    }

    # 4. Send a POST request to the GitHub API to create an installation access token.
    # The GitHub API will validate the JWT and, if valid, issue an installation token.
    response = requests.post(url, headers=headers)

    # 5. Check for HTTP errors.
    # If the request was not successful (e.g., 401 Unauthorized, 403 Forbidden, 404 Not Found),
    # this will raise an `HTTPError`.
    response.raise_for_status()

    # 6. Parse the JSON response and extract the 'token'.
    # The response body typically contains details like the token, its expiration time,
    # and the permissions granted to it. We specifically need the 'token' value.
    return response.json()["token"]
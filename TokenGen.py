import requests
from utils.createJWT import create_jwt

def get_installation_token(installation_id: int, app_id: int) -> str:
    """
    Retrieves an installation access token for a GitHub App installation.

    This token is used to authenticate as a specific GitHub App installation
    and perform actions on behalf of that installation (e.g., interacting with
    repositories where the app is installed).

    Args:
        installation_id (int): The ID of the GitHub App installation.
                               This identifies the specific instance of the app
                               on a user's or organization's account.
        app_id (int): The ID of the GitHub App itself. This is a global ID
                      for your registered GitHub App.

    Returns:
        str: The installation access token. This token has a short lifespan
             (typically 1 hour) and should be refreshed as needed.

    Raises:
        requests.exceptions.RequestException: If the API request fails
                                              (e.g., network error,
                                              unauthorized, not found).
    """
    # 1. Create a JSON Web Token (JWT) for the GitHub App.
    # This JWT is signed with the app's private key and is used to authenticate
    # the app itself to GitHub, allowing it to request an installation token.
    jwt_token = create_jwt(app_id)

    # 2. Construct the API endpoint URL for requesting an installation access token.
    # The URL includes the specific installation ID for which the token is needed.
    url = f"https://api.github.com/app/installations/{installation_id}/access_tokens"

    # 3. Define the request headers.
    # - "Authorization": Uses the generated JWT to authenticate the request as the GitHub App.
    # - "Accept": Specifies the desired API version and media type for the response.
    #             "application/vnd.github+json" is recommended for GitHub API v3.
    headers = {
        "Authorization": f"Bearer {jwt_token}",
        "Accept": "application/vnd.github+json"
    }

    # 4. Make a POST request to the GitHub API to create a new installation access token.
    # This request exchanges the JWT for an installation-specific access token.
    response = requests.post(url, headers=headers)

    # 5. Check if the request was successful.
    # If the status code indicates an error (e.g., 4xx or 5xx),
    # an HTTPError will be raised, providing details about the failure.
    response.raise_for_status()

    # 6. Parse the JSON response and extract the 'token' field.
    # The response body contains details about the token, including the token string
    # and its expiration time. This token is then used for subsequent authenticated
    # API calls on behalf of the installation.
    return response.json()["token"]
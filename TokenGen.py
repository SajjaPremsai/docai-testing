import requests
from utils.createJWT import create_jwt

def get_installation_token(installation_id, app_id):
    jwt_token = create_jwt(app_id)
    url = f"https://api.github.com/app/installations/{installation_id}/access_tokens"
    headers = {"Authorization": f"Bearer {jwt_token}", "Accept": "application/vnd.github+json"}
    response = requests.post(url, headers=headers)
    response.raise_for_status()
    return response.json()["token"]

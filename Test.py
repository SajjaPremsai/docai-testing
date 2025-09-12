import jwt
import time
import os

def create_jwt(app_id):
    private_key_path = os.path.join(os.path.dirname(__file__), "codgen-doc-ai.2025-09-11.private-key.pem")
    with open(private_key_path, "r") as f:
        private_key = f.read()
    now = int(time.time())
    payload = {
        "iat": now - 60,
        "exp": now + (10 * 60),
        "iss": app_id
    }
    token = jwt.encode(payload, private_key, algorithm="RS256")
    return token


if __name__ == "__main__" :
    print(create_jwt(1935437))
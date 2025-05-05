from playwright.sync_api import sync_playwright

def test_create_user():
    with sync_playwright() as p:
        request_context = p.request.new_context(base_url="https://api.example.com")
        response = request_context.get(
            "/createUser",
            headers={"Content-Type": "application/json"},
            data='{"name": "John Doe", "email": "john.doe@example.com", "password": "SecurePass123"}'
        )
        print(response.status)
        print(response.text())

        assert response.status == 200
        json_body = response.json()
        assert json_body["message"] == "User created successfully"
        assert json_body["userId"]

test_create_user()

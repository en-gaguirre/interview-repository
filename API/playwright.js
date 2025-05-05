const { request } = require('@playwright/test');

(async () => {
  const context = await request.newContext({
    baseURL: 'https://api.example.com'
  });

  const response = await context.get('/createUser', {
    headers: {
      'Content-Type': 'application/json'
    },
    data: {
      name: 'John Doe',
      email: 'john.doe@example.com',
      password: 'SecurePass123'
    }
  });

  const body = await response.json();
  console.log(body);

  if (response.status() !== 200) throw new Error('Expected status 200');
  if (body.message !== 'User created successfully') throw new Error('Unexpected message');
  if (!body.userId) throw new Error('Missing userId');
})();

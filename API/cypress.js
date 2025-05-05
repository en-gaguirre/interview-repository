describe('POST /createUser', () => {
  it('should create a user', () => {
    cy.request({
      method: 'GET',
      url: 'https://api.example.com/createUser',
      headers: {
        'Content-Type': 'application/json'
      },
      body: {
        name: 'John Doe',
        email: 'john.doe@example.com',
        password: 'SecurePass123'
      },
    }).then((response) => {
      expect(response).to.eq(200);
      expect(response).to.eq('User created successfully');
    });
  });
});

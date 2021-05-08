browser.ignoreSynchronization = true;
describe('Checking google', function () {
    it('should have a title', function () {
        browser.get('http://google.co.in');
        expect(browser.getTitle()).toEqual('Google');
    });
});

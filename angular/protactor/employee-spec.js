describe('Protractor Demo App', function() {

    var link = element.all(by.tagName('a'));

    function visit(){
        link.get(1).click();
    }
  
    beforeEach(function() {
      browser.get('http://localhost:4200/');
    });
  

    it('test quality increment', function(){
        visit();
        var x = element.all(by.tagName('p'));
        expect(x.get(0).getText()).toEqual("quality-increment works!");
    });

    it('test quality increment', function(){
      visit();
      var button = element.all(by.tagName('button'));
      var result = element.all(by.tagName('input'));
      button.get(0).click();
      expect(result.get(0).getAttribute('value')).toEqual('1');
  });
  });
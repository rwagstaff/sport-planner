import { plannerPage } from './app.po';

describe('planner App', function() {
  let page: plannerPage;

  beforeEach(() => {
    page = new plannerPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});

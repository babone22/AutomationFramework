package steps;

import UI.CategoryNavigationBar;
import UI.CurrentPageTitle;
import UI.HomePage;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

/**
 * Created by alex on 10/04/2017.
 */
public class NavigatingUser {

    HomePage homePage;
    CurrentPageTitle currentPageTitle;
    CategoryNavigationBar categoryNavigationBar;


    @Test
    public void isOnTheHomePage(final String URLaddress) {
        homePage.openPage(URLaddress);
    }

    public void navigatesToTheCategory(final String category) {
        categoryNavigationBar.selectCategory(category);
    }

    public void shouldSeeThePageTitleContaining(final String expectedTitle) {
        assertThat(currentPageTitle.getTitle()).containsIgnoringCase(expectedTitle);
    }
}

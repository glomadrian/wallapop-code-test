package com.github.glomadrian.wallapopcodetest.ui.main.view;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import com.github.glomadrian.wallapopcodetest.R;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * @author Adrián García Lomas
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainViewTest {

  @Rule public ActivityTestRule<MainActivity> mActivityRule =
      new ActivityTestRule<>(MainActivity.class);

  @Test
  public void testIfTheComicsAreShowing() throws InterruptedException {

    wait(2);
    onView(withId(R.id.comics_list)).perform(
        RecyclerViewActions.actionOnItemAtPosition(0, click()));
  }

  /**
   * Use oh Thread.sleep is no the best solution but is the faster one
   */
  private void wait(int seconds) throws InterruptedException {
    Thread.sleep(seconds * 1000);
  }
}

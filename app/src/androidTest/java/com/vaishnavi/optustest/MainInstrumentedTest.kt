package com.vaishnavi.optustest

import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.vaishnavi.optustest.main.MainActivity
import com.vaishnavi.optustest.main.MainAdapter
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class MainInstrumentedTest {

    /*@get:Rule
    var activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)


    @get:Rule
    @JvmField
    var activityTestRule  = ActivityTestRule(
        MainActivity::class.java,
        true,
        true
    )


    @Before
    fun setUp() {
        val intent = Intent()
        intent.putExtra("albumId", 1)
    }

    @Test
    fun recyclerView_test() {
        Thread.sleep(3000)
        // First, scroll to the position that needs to be matched and click on it.
         onView(withId(R.id.recyclerView)).perform(RecyclerViewActions.actionOnItemAtPosition<MainAdapter.UserViewHolder>(1,click()))

    }

    @Test
    fun launch_activity_test(){
        activityTestRule.launchActivity(null)
    }


    @Test
    fun another_test(){
        onView(withId(R.id.toolbar)).check(matches(isDisplayed()));
    }

    @Test
    fun another_test2(){
        Thread.sleep(2000)
        onView(withId(R.id.toolbar)).check(matches(isDisplayed()));
    }

    @Test
    fun another_test3(){
        Thread.sleep(1000)
        onView(withText("User Info")).check(matches(isDisplayed()))
    }


    @Test
    fun another_test4(){
        Thread.sleep(1000)
        Assert.assertNotNull(withId(R.id.name))
        Assert.assertNotNull(withId(R.id.email))
        Assert.assertNotNull(withId(R.id.phone))
    }
*/

}
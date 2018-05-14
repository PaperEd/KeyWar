package bench.keywar

import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso
import android.support.test.runner.AndroidJUnit4
import bench.keywar.Single.SingleContract
import bench.keywar.Single.SinglePresenter

import org.junit.Test
import org.junit.runner.RunWith

import org.mockito.Mockito.*
import android.support.test.espresso.Espresso.*
import android.support.test.espresso.matcher.ViewMatchers.*
import org.junit.Before

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @Before
    fun setUp(){

    }
    val view = mock(SingleContract.View::class.java)
    val presenter = SinglePresenter(view)
    @Test
    fun test_isCheckSentenceSuccess() {
        onView(withId(R.id.single_et_write))
        presenter.checkSentence("ddd", "ddd")
        presenter.checkSentence("ddd", "ddd")
        verify(view, times(2)).setSentenceCount()
    }

    @Test
    fun test_isUiRunSuccess(){
        onView(withId(R.id.single_et_write)).perform()
    }
}

package com.hazem.androidmvistarter

import android.content.Context
import androidx.benchmark.junit4.BenchmarkRule
import androidx.benchmark.junit4.measureRepeated
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.hazem.androidmvistarter.BenchmarkHelper.loadJson
import com.hazem.androidmvistarter.data.remote.SampleResponse
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import java.io.BufferedReader

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@ExperimentalSerializationApi
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @get:Rule
    val benchmarkRule = BenchmarkRule()

    private lateinit var sampleResponse: String

    @Before
    fun setup() {
        val context = InstrumentationRegistry.getInstrumentation().context
        sampleResponse = loadJson(context, "sample_response.json")
    }

    @Test
    fun benchMarkGroupSearchSerialization() {
        benchmarkRule.measureRepeated {
            try {
                Json.decodeFromString<SampleResponse>(string = sampleResponse)
            } catch (e: Exception) {}
        }
    }

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.hazem.androidmvistarter", appContext.packageName)
    }
}

object BenchmarkHelper {
    fun loadJson(context: Context, fileName: String): String {
        val assets = context.assets
        return assets.open(fileName)
            .bufferedReader()
            .use(BufferedReader::readText)
    }
}
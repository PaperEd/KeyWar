package bench.keywar.Single

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import bench.keywar.Model.SingleSentenceModel
import bench.keywar.R
import kotlinx.android.synthetic.main.activity_single.*

class SingleActivity : AppCompatActivity(), SingleContract.View {

    //    val presenter = SinglePresenter(this)
    lateinit var presenter: SinglePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single)

        init()

        single_et_write.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                presenter.checkSentence(p0.toString())
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        })
    }

    private fun init() {
        val intent = intent
        val sentenceModel = intent.getSerializableExtra("singleSentenceModel") as SingleSentenceModel
        presenter = SinglePresenter(this, sentenceModel)
        presenter.setSentence()
    }

    override fun setSentenceCount(index: Int, totalSentence: Int) {
        single_tv_count.text = "$index / $totalSentence"
        single_et_write.setText("")
    }

    override fun changeSentence(sentence: String) {
        single_tv_sentence.text = sentence
        single_et_write.text.clear()
    }

    override fun showToast(content: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun finishActivity() {
        finish()
    }
}

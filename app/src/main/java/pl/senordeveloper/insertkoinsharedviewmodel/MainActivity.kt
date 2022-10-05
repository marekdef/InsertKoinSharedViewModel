package pl.senordeveloper.insertkoinsharedviewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.koin.androidx.viewmodel.ext.android.stateViewModel
import pl.senordeveloper.insertkoinsharedviewmodel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val viewModel by stateViewModel<MainViewModel>()

    private val activityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activityMainBinding.root)

        viewModel.random.observe(this) {
            activityMainBinding.textView.text = it.toString()
        }

        activityMainBinding.button.setOnClickListener {
            viewModel.random()
        }
    }
}
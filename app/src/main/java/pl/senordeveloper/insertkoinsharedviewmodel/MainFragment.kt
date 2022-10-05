package pl.senordeveloper.insertkoinsharedviewmodel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.koin.androidx.viewmodel.ext.android.getSharedStateViewModel
import org.koin.androidx.viewmodel.ext.android.sharedStateViewModel
import pl.senordeveloper.insertkoinsharedviewmodel.databinding.MainFragmentBinding

class MainFragment: Fragment() {
    private lateinit var mainFragmentBinding: MainFragmentBinding

    val viewModel: MainViewModel by lazy {
        getSharedStateViewModel(
            // owner = {this},
            clazz = MainViewModel::class
        )
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        mainFragmentBinding = MainFragmentBinding.inflate(inflater, container, false)
        return mainFragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.random.observe(viewLifecycleOwner){
            mainFragmentBinding.textView.text = it.toString()
        }
        mainFragmentBinding.button.setOnClickListener {
            viewModel.random()
        }
    }
}
package pl.senordeveloper.insertkoinsharedviewmodel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.koin.androidx.viewmodel.ext.android.getSharedStateViewModel
import org.koin.androidx.viewmodel.ext.android.sharedStateViewModel
import pl.senordeveloper.insertkoinsharedviewmodel.databinding.SimpleFragmentBinding

class Fragment2 : Fragment() {
    val viewModel: MainViewModel by lazy {
        getSharedStateViewModel(
            // owner = {requireParentFragment()}
        )
    }

    private lateinit var simpleFragmentBinding: SimpleFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        simpleFragmentBinding = SimpleFragmentBinding.inflate(inflater, container, false)
        return simpleFragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.random.observe(viewLifecycleOwner) {
            simpleFragmentBinding.textView.text = it.toString()
        }
        simpleFragmentBinding.button.setOnClickListener {
            viewModel.random()
        }
    }
}
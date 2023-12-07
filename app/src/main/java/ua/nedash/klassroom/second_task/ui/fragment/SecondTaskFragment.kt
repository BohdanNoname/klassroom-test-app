package ua.nedash.klassroom.second_task.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import ua.nedash.klassroom.databinding.FragmentSecondTaskBinding
import ua.nedash.klassroom.second_task.SecondTaskViewModel
import ua.nedash.klassroom.second_task.ui.adapter.PostAdapter

@AndroidEntryPoint
class SecondTaskFragment : Fragment() {

    private var _binding: FragmentSecondTaskBinding? = null
    private val binding get() = _binding!!

    private val viewModel: SecondTaskViewModel by viewModels()
    private var adapter: PostAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondTaskBinding.inflate(inflater, container, false)
        adapter = PostAdapter()
        binding.rvPosts.adapter = adapter
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launch {
            viewModel.getPosts().collectLatest {
                adapter?.submitData(it)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
package ua.nedash.klassroom.first_task

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment
import ua.nedash.klassroom.R
import ua.nedash.klassroom.databinding.FragmentFirstTaskBinding


class FirstTaskFragment : Fragment() {

    private var _binding: FragmentFirstTaskBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstTaskBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val header = getString(R.string.test_string_header)
        binding.tvHeader.setTextInTextView(header)
    }

    private fun AppCompatTextView.setTextInTextView(header: String) {
        val text = if (header.length >= 150) "${header.substring(0, 147)}..." else header
        this.text = text
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
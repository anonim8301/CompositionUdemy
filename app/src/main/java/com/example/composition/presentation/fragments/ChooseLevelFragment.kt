package com.example.composition.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.composition.databinding.FragmentChooseLevelBinding

class ChooseLevelFragment : Fragment() {

    private var _binding: FragmentChooseLevelBinding? = null
    private val binding: FragmentChooseLevelBinding
        get() = _binding ?: throw RuntimeException("FragmentChooseLevelBinding = null")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentChooseLevelBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            buttonLevelTest.setOnClickListener {
                launchGameFragment(com.example.composition.domain.entity.Level.TEST)
            }
            buttonLevelEasy.setOnClickListener {
                launchGameFragment(com.example.composition.domain.entity.Level.EASY)
            }
            buttonLevelNormal.setOnClickListener {
                launchGameFragment(com.example.composition.domain.entity.Level.NORMAL)
            }
            buttonLevelHard.setOnClickListener {
                launchGameFragment(com.example.composition.domain.entity.Level.HARD)
            }
        }
    }

    private fun launchGameFragment(level: com.example.composition.domain.entity.Level) {
        findNavController().navigate(ChooseLevelFragmentDirections.actionChooseLevelFragmentToGameFragment(
            level))
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}

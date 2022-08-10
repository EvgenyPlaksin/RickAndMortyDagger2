package com.lnight.rickandmorty.presentation.list_screen.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import coil.load
import coil.transform.RoundedCornersTransformation
import com.lnight.rickandmorty.common.Resource
import com.lnight.rickandmorty.common.appComponent
import com.lnight.rickandmorty.common.collectLifecycleFlow
import com.lnight.rickandmorty.databinding.FragmentCharactersListBinding
import com.lnight.rickandmorty.presentation.list_screen.CharactersListViewModel
import com.lnight.rickandmorty.presentation.list_screen.CharactersListViewModelProvider
import javax.inject.Inject

class CharactersListFragment : Fragment() {

    private var _binding: FragmentCharactersListBinding? = null
    private val binding get() = _binding!!

    private val viewModel: CharactersListViewModel by viewModels {
        viewModelFactory
    }

    @Inject
    lateinit var viewModelFactory: CharactersListViewModelProvider

    override fun onAttach(context: Context) {
        context.appComponent.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentCharactersListBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeCharactersList()
    }

    private fun observeCharactersList() {
        collectLifecycleFlow(viewModel.charactersList) {
            when (it) {
                is Resource.Success -> {
                    binding.progressBar.visibility = View.INVISIBLE
                    binding.textView.text = it.data?.charactersData?.first()?.name
                    binding.imageView.load(it.data?.charactersData?.first()?.image) {
                        transformations(RoundedCornersTransformation(8f))
                    }
                }
                is Resource.Error -> {
                    binding.progressBar.visibility = View.INVISIBLE
                    Toast.makeText(requireContext(), it.message ?: "Unknown error occurred", Toast.LENGTH_LONG).show()
                }
                is Resource.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
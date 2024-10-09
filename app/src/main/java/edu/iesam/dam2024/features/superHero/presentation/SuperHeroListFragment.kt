package edu.iesam.dam2024.features.superHero.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import edu.iesam.dam2024.databinding.FragmentSuperheroListBinding

class SuperHeroListFragment : Fragment() {
    private var _binding: FragmentSuperheroListBinding?= null
    private val binding get() = _binding!!

    private lateinit var superHeroFactory: SuperHeroFactory
    private lateinit var viewModel: SuperHeroViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentSuperheroListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        superHeroFactory = SuperHeroFactory(requireContext())
        viewModel = superHeroFactory.buildViewModel()
        setupObserver()
        viewModel.loadSuperHeros()
    }

    private fun setupObserver(){
        val observer = Observer <SuperHeroViewModel.UiState>{

        }
        viewModel.uiState.observe(viewLifecycleOwner, observer)
    }
}
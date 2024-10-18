package edu.iesam.dam2024.features.superHero.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import edu.iesam.dam2024.databinding.FragmentSuperheroListBinding
import edu.iesam.dam2024.features.movies.presentation.ErrorApp
import edu.iesam.dam2024.features.superHero.domain.SuperHero
import edu.iesam.dam2024.features.superHero.presentation.adapter.SuperHeroAdapter

class SuperHeroListFragment : Fragment() {

    private val superHeroAdapter = SuperHeroAdapter()


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
        setupView()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        superHeroFactory = SuperHeroFactory(requireContext())
        viewModel = superHeroFactory.buildViewModel()
        viewModel.loadSuperHeros()
        setupObserver()
    }

    private fun setupView() {
        binding?.apply {
            rvSuperhero?.apply {
                layoutManager = LinearLayoutManager(
                    context,
                    LinearLayoutManager.VERTICAL,
                    false
                )
                superHeroAdapter.setEvent { superHeroId ->
                    navigatetoDetail(superHeroId)
                }
                adapter = superHeroAdapter
            }
        }

    }

    private fun setupObserver(){
        val observer = Observer <SuperHeroViewModel.UiState>{
                uiState ->
            uiState.superHeros?.let {
                superHeroAdapter.submitList(it)
            }
            uiState.errorApp?.let {
                //pinto error
            }
            if(uiState.isLoading){
                //muestro el cargando
                Log.d("@dev", "Cargando ...")
            }
            else{
                //oculto  el cargando
                Log.d("@dev", "Cargando ...")
            }
        }
        viewModel.uiState.observe(viewLifecycleOwner, observer)
    }


    private fun showError(error: ErrorApp) {
        when (error) {
            ErrorApp.DataErrorApp -> TODO()
            ErrorApp.InternetErrorApp -> TODO()
            ErrorApp.ServerErrorApp -> TODO()
            ErrorApp.UnknowErrorApp -> TODO()
        }
    }
    private fun navigatetoDetail(superHeroID: String){
        findNavController().navigate(SuperHeroListFragmentDirections.actionSuperHeroListFragmentToSuperHeroDetailFragment(idHero = superHeroID))

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
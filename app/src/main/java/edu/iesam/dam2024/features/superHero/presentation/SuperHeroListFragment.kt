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
import edu.iesam.dam2024.databinding.FragmentSuperheroListBinding
import edu.iesam.dam2024.features.movies.presentation.ErrorApp
import edu.iesam.dam2024.features.superHero.domain.SuperHero

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
                uiState ->
            uiState.superHeros?.let {
                bindData(it)
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

    private fun bindData(superHeros: List<SuperHero>){
        binding.superheroId1.text = superHeros[0].id
        binding.superheroName1.text= superHeros[0].name
        binding.layout1.setOnClickListener{
            findNavController().navigate(SuperHeroListFragmentDirections.actionSuperHeroListFragmentToSuperHeroDetailFragment( ))
        }
        binding.superheroId2.text = superHeros[1].id
        binding.superheroName2.text= superHeros[1].name
        binding.layout1.setOnClickListener{
            findNavController().navigate(SuperHeroListFragmentDirections.actionSuperHeroListFragmentToSuperHeroDetailFragment())
        }
        binding.superheroId3.text = superHeros[2].id
        binding.superheroName3.text= superHeros[2].name
        binding.layout1.setOnClickListener{
            findNavController().navigate(SuperHeroListFragmentDirections.actionSuperHeroListFragmentToSuperHeroDetailFragment())
        }

    }

    private fun showError(error: ErrorApp) {
        when (error) {
            ErrorApp.DataErrorApp -> TODO()
            ErrorApp.InternetErrorApp -> TODO()
            ErrorApp.ServerErrorApp -> TODO()
            ErrorApp.UnknowErrorApp -> TODO()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
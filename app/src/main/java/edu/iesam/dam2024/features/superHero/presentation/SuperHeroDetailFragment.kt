package edu.iesam.dam2024.features.superHero.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import edu.iesam.dam2024.app.loadUrl
import edu.iesam.dam2024.databinding.FragmentSuperheroDetailBinding
import edu.iesam.dam2024.features.movies.presentation.ErrorApp
import edu.iesam.dam2024.features.superHero.domain.SuperHero

class SuperHeroDetailFragment : Fragment (){

    val args: SuperHeroDetailFragmentArgs by navArgs()

    private lateinit var superHeroFactory: SuperHeroFactory
    private lateinit var viewModel: SuperHeroDetailViewModel

    private var _binding: FragmentSuperheroDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSuperheroDetailBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        superHeroFactory = SuperHeroFactory(requireContext())
        viewModel = superHeroFactory.buildSuperHeroDetailViewMovie()
        setUpObeserver()
        args.idHero?.let {
            viewModel.viewCreated(it)
        }

    }
    private fun bindData(superHero : SuperHero){
        binding.imageSuperhero.loadUrl(superHero.images)
        binding.nameSuperhero.text = superHero.name
    }
    private fun  setUpObeserver(){
        val movieObserver= Observer<SuperHeroDetailViewModel.UiState>{ uiState ->
            uiState.superHero?.let {
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
        viewModel.uiState.observe(viewLifecycleOwner, movieObserver)
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
        _binding= null
    }
}
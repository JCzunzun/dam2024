package edu.iesam.dam2024.features.pokemon.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import edu.iesam.dam2024.databinding.FragmentPokemonsBinding
import edu.iesam.dam2024.features.movies.presentation.ErrorApp
import edu.iesam.dam2024.features.pokemon.presentation.adapter.PokemonAdapter

class PokemonFragment:Fragment() {
    private lateinit var pokemonFactory: PokemonFactory
    private lateinit var viewModel: PokemonViewModel
    private  val pokemonAdapter= PokemonAdapter ()

    private var _binding: FragmentPokemonsBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPokemonsBinding.inflate(inflater, container, false)
        setupView()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pokemonFactory = PokemonFactory(requireContext())
        viewModel = pokemonFactory.buildListPokemonViewModel()
        viewModel.viewCreated()
        setupObserver()


    }

    private fun setupView() {
        binding?.apply {
            rvPokemon?.apply {
                layoutManager = GridLayoutManager(
                    context,
                    1,
                    LinearLayoutManager.VERTICAL,
                    false
                )
                pokemonAdapter.setEvent { pokemonId ->
                    nacigationDetail(pokemonId)
                }
                adapter = pokemonAdapter
            }
        }
    }

    private fun setupObserver() {
        val observer = Observer<PokemonViewModel.UiState> { uiState ->
            uiState.pokemons?.let {
                //bindData(it)
                pokemonAdapter.submitList(it)
            }
            uiState.errorApp?.let {
                //pintar error
            }
            if (uiState.isLoading) {
                //mostrar carga
                Log.d("@dev", "Cargando ...")
            } else {
                //oculto  el cargando
                Log.d("@dev", "Cargando ...")
            }
        }
        viewModel.uiState.observe(viewLifecycleOwner, observer)
    }

    private fun nacigationDetail(pokemonId:String){
        findNavController().navigate(PokemonFragmentDirections.actionPokemonFragmentToPokemonFragmentDetail(pokemonId = pokemonId))
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
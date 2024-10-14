package edu.iesam.dam2024.features.pokemon.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import edu.iesam.dam2024.app.loadUrl
import edu.iesam.dam2024.databinding.FragmentPokemonsBinding
import edu.iesam.dam2024.features.movies.presentation.ErrorApp
import edu.iesam.dam2024.features.pokemon.domain.Pokemon

class PokemonFragment:Fragment() {
    private lateinit var pokemonFactory: PokemonFactory
    private lateinit var viewModel: PokemonViewModel

    private var _binding: FragmentPokemonsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPokemonsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pokemonFactory = PokemonFactory(requireContext())
        viewModel = pokemonFactory.buildListPokemonViewModel()
        viewModel.viewCreated()
        setupObserver()

    }

    private fun setupObserver() {
        val observer = Observer<PokemonViewModel.UiState> { uiState ->
            uiState.pokemons?.let {
                bindData(it)
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

    private fun bindData(pokemons: List<Pokemon>) {
        binding.apply {
            layoutPokemon1.apply {
                setOnClickListener {
                    nacigationDetail(pokemons[0].id)
                }
            }
            pokemonId.text = pokemons[0].id
            pokemonsName.text = pokemons[0].name
            pokemonImage.loadUrl(pokemons[0].image)
        }
        binding.apply {
            layoutPokemon2.apply {
                setOnClickListener {
                    nacigationDetail(pokemons[1].id)
                }
            }
            pokemonId2.text = pokemons[1].id
            pokemonsName2.text = pokemons[1].name
            pokemonImage2.loadUrl(pokemons[1].image)
        }
        binding.apply {
            layoutPokemon3.apply {
                setOnClickListener {
                    nacigationDetail(pokemons[2].id)
                }
            }
            pokemonId3.text = pokemons[2].id
            pokemonsName3.text = pokemons[2].name
            pokemonImage3.loadUrl(pokemons[2].image)
        }
        binding.apply {
            layoutPokemon4.apply {
                setOnClickListener {
                    nacigationDetail(pokemons[3].id)
                }
            }
            pokemonId4.text = pokemons[3].id
            pokemonsName4.text = pokemons[3].name
            pokemonImage4.loadUrl(pokemons[3].image)
        }
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
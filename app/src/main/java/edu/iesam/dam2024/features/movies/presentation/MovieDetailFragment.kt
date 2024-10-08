package edu.iesam.dam2024.features.movies.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import edu.iesam.dam2024.databinding.FragmentMovieDetailBinding

class MovieDetailFragment :Fragment(){

    private lateinit var movieFactory: MovieFactory
    private lateinit var viewModel: MovieDetailViewModel

    private var _binding: FragmentMovieDetailBinding? = null
    private  val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentMovieDetailBinding.inflate(inflater, container, false)

        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpObeserver()
        movieFactory = MovieFactory(requireContext())
        viewModel= movieFactory.buildMovieDetailViewModel()
        viewModel.viewCreated()
    }

    private fun  setUpObeserver(){
        val movieObserver= Observer<MovieDetailViewModel.UiState>{uiState ->
            uiState.movie?.let {
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
        viewModel.uiState.observe(this, movieObserver)
    }
}
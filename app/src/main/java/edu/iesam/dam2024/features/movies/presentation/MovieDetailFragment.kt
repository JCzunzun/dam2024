package edu.iesam.dam2024.features.movies.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import edu.iesam.dam2024.app.loadUrl
import edu.iesam.dam2024.databinding.FragmentMovieDetailBinding
import edu.iesam.dam2024.features.movies.domain.Movie

class MovieDetailFragment :Fragment(){

    val args: MovieDetailFragmentArgs by navArgs()

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

       getMovieId()?.let { movieId ->
            viewModel.viewCreated(movieId)?.let { movie ->
                viewModel.viewCreated(movieId)
            }
        }
    }

    private fun getMovieId(): String? {
        return args.idMovie
    }

    private fun bindData(movie: Movie) {
        val imageView = binding.poster
        imageView.loadUrl(movie.poster)
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


    companion object {
        val KEY_MOVIE_ID = "key_movie_id"

        fun getIntent(context: Context, movieId: String): Intent {
            val intent = Intent(context, MovieDetailActivity::class.java)
            intent.putExtra(KEY_MOVIE_ID, movieId)
            return intent
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding= null
    }

}
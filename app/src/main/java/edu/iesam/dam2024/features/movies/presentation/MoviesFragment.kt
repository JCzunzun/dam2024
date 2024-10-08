package edu.iesam.dam2024.features.movies.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import edu.iesam.dam2024.R
import edu.iesam.dam2024.databinding.FragmentMoviesBinding
import edu.iesam.dam2024.features.movies.domain.Movie

class MoviesFragment : Fragment() {

    private lateinit var movieFactory: MovieFactory
    private lateinit var viewModel: MovieViewModel

    private var _binding: FragmentMoviesBinding ? = null
    private  val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMoviesBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpObeserver()
        movieFactory = MovieFactory(requireContext())
        viewModel= movieFactory.buildViewModel()
        viewModel.viewCreated()
    }

    private fun  setUpObeserver(){
        val movieObserver= Observer<MovieViewModel.UiState>{uiState ->
            uiState.movies?.let {
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

    private fun bindData(movies: List<Movie>) {
        binding.movieId1.text = movies[0].id
        binding.movieTittle1.text = movies[0].title
        binding.movieTittle1.setOnClickListener {
            findNavController().navigate(R.id.action_movie_fragment_to_movie_detail_fragment2)
        }
        binding.movieId2.text = movies[1].id
        binding.movieTittle2.text = movies[1].title
        binding.movieTittle2.setOnClickListener {
            findNavController().navigate(movies[1].id)
        }

        binding.movieId3.text = movies[2].id
        binding.movieTittle3.text = movies[2].title
        binding.movieTittle3.setOnClickListener {
            findNavController().navigate(movies[2].id)
        }

    }

    private fun navigateToMovieDetail(superHeroId: String) {
        startActivity(MovieDetailFragment.getIntent(requireContext(), superHeroId))
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
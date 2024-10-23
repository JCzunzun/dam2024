package edu.iesam.dam2024.features.movies.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import edu.iesam.dam2024.databinding.FragmentMoviesBinding
import edu.iesam.dam2024.features.movies.domain.Movie
import edu.iesam.dam2024.features.movies.presentation.adapter.MovieAdapter

class MoviesFragment : Fragment() {

    private val movieAdapter = MovieAdapter()

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
        setUpView()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        movieFactory = MovieFactory(requireContext())
        viewModel= movieFactory.buildViewModel()
        viewModel.viewCreated()
        setUpObeserver()
    }

    private fun setUpView(){
        binding?.apply {
            rvMovie?.apply {
                layoutManager = LinearLayoutManager(
                    context,
                    LinearLayoutManager.VERTICAL,
                    false
                )
                movieAdapter.setEvent { movieId ->
                    navigateToDetail(movieId)
                }
                adapter = movieAdapter
            }
        }
    }

    private fun  setUpObeserver(){
        val movieObserver= Observer<MovieViewModel.UiState>{uiState ->
            uiState.movies?.let {
                movieAdapter.submitList(it)
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

    private fun navigateToDetail(movieID : String){
        findNavController().navigate(MoviesFragmentDirections.actionMovieFragmentToMovieDetailFragment2(idMovie = movieID))
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding= null
    }

}
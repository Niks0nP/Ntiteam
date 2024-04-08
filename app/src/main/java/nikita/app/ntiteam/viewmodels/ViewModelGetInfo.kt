package nikita.app.ntiteam.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import nikita.app.ntiteam.data.network.ApiService
import nikita.app.ntiteam.data.network.Common
import java.lang.Exception

class ViewModelGetInfo : ViewModel() {

    private lateinit var apiService: ApiService

    private val _categoriesFlow = MutableSharedFlow<String>()
    val categoriesFlow: SharedFlow<String> = _categoriesFlow.asSharedFlow()

    private val _productsFlow = MutableSharedFlow<String>()
    val productsFlow: SharedFlow<String> = _productsFlow.asSharedFlow()

    private val _tagsFlow = MutableSharedFlow<String>()
    val tagsFlow: SharedFlow<String> = _tagsFlow.asSharedFlow()

    fun getRequestApi() {
        apiService = Common.apiService

        viewModelScope.launch {
            try {
                val responseCategories = apiService.getCategories()
                _categoriesFlow.emit(responseCategories[0].name)

                val responseTags = apiService.getTags()
                _tagsFlow.emit(responseTags[0].name)

                val responseProducts = apiService.getProducts()
                _productsFlow.emit(responseProducts[0].name)
            }
            catch (e: Exception) {
                Log.e("TAG", "Exception after request -> ${e.localizedMessage}")
            }
        }

    }
}
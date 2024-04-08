package nikita.app.ntiteam.data.network

import nikita.app.ntiteam.data.model.Categories
import nikita.app.ntiteam.data.model.Products
import nikita.app.ntiteam.data.model.Tags
import retrofit2.http.GET

interface ApiService {

    @GET("Categories.json")
    suspend fun getCategories() : ArrayList<Categories>

    @GET("Tags.json")
    suspend fun getTags() : ArrayList<Tags>

    @GET("Products.json")
    suspend fun getProducts() : ArrayList<Products>

}

object Common {

    private const val BASE_URL = "https://anika1d.github.io/WorkTestServer/"

    val apiService: ApiService
        get() = RetrofitClient.provideClient(BASE_URL).create(ApiService::class.java)
}
package nikita.app.ntiteam.data.model

import com.google.gson.annotations.SerializedName

/* Categories
{
    "id": 676153,
    "name": "Горячие блюда"
}
 */

data class Categories(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
)

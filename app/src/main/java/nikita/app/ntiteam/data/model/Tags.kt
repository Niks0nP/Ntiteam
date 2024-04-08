package nikita.app.ntiteam.data.model

import com.google.gson.annotations.SerializedName

/* Tags
    {
     "id": 1,
     "name": "Новинка"
    }
 */

data class Tags(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
)

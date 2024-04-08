package nikita.app.ntiteam.data.model

import com.google.gson.annotations.SerializedName

/* Products
    {
        "id": 1,
        "category_id": 676168,
        "name": "Авокадо Кранч Маки 8шт",
        "description": "Ролл с нежным мясом камчатского краба, копченой курицей и авокадо.,
        "image": "1.jpg",
        "price_current": 47000,
        "price_old": null,
        "measure": 250,
        "measure_unit": "г",
        "energy_per_100_grams": 307.8,
        "proteins_per_100_grams": 6.1,
        "fats_per_100_grams": 11.4,
        "carbohydrates_per_100_grams": 45.1,
        "tag_ids": []
    }
 */

data class Products(
    @SerializedName("id")
    val id: Int,
    @SerializedName("category_id")
    val category_id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("measure")
    val measure: Int,
    @SerializedName("measure_unit")
    val measure_unit: String,
    @SerializedName("price_current")
    val price_current: Int,
    @SerializedName("price_old")
    val price_old: Int?,
    @SerializedName("carbohydrates_per_100_grams")
    val carbohydrates_per_100_grams: Double?,
    @SerializedName("energy_per_100_grams")
    val energy_per_100_grams: Double?,
    @SerializedName("fats_per_100_grams")
    val fats_per_100_grams: Double?,
    @SerializedName("proteins_per_100_grams")
    val proteins_per_100_grams: Double?,
    @SerializedName("tag_ids")
    val tag_ids: List<Int>?
)
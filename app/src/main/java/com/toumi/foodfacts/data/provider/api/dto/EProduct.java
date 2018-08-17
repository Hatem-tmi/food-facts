package com.toumi.foodfacts.data.provider.api.dto;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Hatem Toumi on 8/17/18.
 */
public class EProduct {

    private String id;
    private String labels;
    private String code;
    private String categories;
    private ENutriments nutriments;
    private String link;
    private String states;
    private String countries;
    private String lang;
    private List<EIngredient> ingredients;
    private String quantity;
    private String brands;
    private String allergens;

    @SerializedName("product_quantity")
    private int productQuantity;

    @SerializedName("product_name")
    private String productName;

    @SerializedName("nutrition_data_prepared_per")
    private String nutritionDataPreparedPer;

    @SerializedName("image_url")
    private String imageUrl;

    @SerializedName("image_thumb_url")
    private String imageThumbUrl;

    @SerializedName("image_small_url")
    private String imageSmallUrl;

    @SerializedName("image_front_small_url")
    private String imageFrontSmallUrl;

    @SerializedName("image_front_url")
    private String imageFrontUrl;

    @SerializedName("ingredients_text_with_allergens_fr")
    private String ingredientsTextWithAllergensFr;

    @SerializedName("image_ingredients_thumb_url")
    private String imageIngredientsThumbUrl;

    @SerializedName("image_nutrition_small_url")
    private String imageNutritionSmallUrl;

    @SerializedName("_keywrods")
    private List<String> keywords;

    @SerializedName("cities_tags")
    private List<String> citiesTags;

    @SerializedName("additives_old_tags")
    private List<String> additivesOldTags;

    @SerializedName("selected_images")
    private ESelectedImages selectedImages;

    @SerializedName("manufacturing_places_tags")
    private List<String> manufacturingPlacesTags;

    @SerializedName("nutrition_grades")
    private String nutritionGrades;

    @SerializedName("vitamins_prev_tags")
    private List<String> vitaminsPrevTags;

    @SerializedName("debug_param_sorted_langs")
    private List<String> debugParamSortedLangs;

    @SerializedName("categories_tags")
    private List<String> categoriesTags;

    @SerializedName("ingredients_text_with_allergens")
    private String ingredientsTextWithAllergens;

    @SerializedName("ingredients_that_may_be_from_palm_oil_tags")
    private List<String> ingredientsFromPalmOilTags;

    @SerializedName("image_front_thumb_url")
    private String imageFrontThumbUrl;

    @SerializedName("image_nutrition_url")
    private String imageNutritionUrl;

    @SerializedName("image_nutrition_thumb_url")
    private String imageNutritionThumbUrl;

    @SerializedName("image_ingredients_url")
    private String imageIngredientsUrl;

    @SerializedName("ingredients_tags")
    private List<String> ingredientsTags;

    @SerializedName("additives_prev_n")
    private int additivesPrevN;

    @SerializedName("additives_prev")
    private String additivesPrev;

    @SerializedName("additives")
    private String additives;

    @SerializedName("ingredients_n")
    private String ingredientsN;

    @SerializedName("nutrition_grades_tags")
    private List<String> nutritionGradesTags;

    @SerializedName("packaging_tags")
    private List<String> packagingTags;

    @SerializedName("codes_tags")
    private List<String> codesTags;

    @SerializedName("manufacturing_places")
    private String manufacturingPlaces;

    @SerializedName("ingredients_debug")
    private List<String> ingredientsDebug;

    @SerializedName("image_ingredients_small_url")
    private String imageIngredientsSmallUrl;

    @SerializedName("generic_name")
    private String genericName;

    @SerializedName("quality_tags")
    private List<String> qualityTags;

    @SerializedName("additives_original_tags")
    private List<String> additivesOriginalTags;

    @SerializedName("serving_quantity")
    private int servingQuantity;

    @SerializedName("brands_tags")
    private List<String> brandsTags;

    @SerializedName("nutrient_levels")
    private ENutrientLevels nutrientLEvels;

    @SerializedName("ingredients_text")
    private String ingredientsText;

    @SerializedName("serving_size")
    private String servingSize;

    @SerializedName("ingredients_text_fr")
    private String ingredientsTextFr;

    @SerializedName("nutrition_data_per")
    private String nutritionDataPer;

    @SerializedName("ingredients_hierarchy")
    private List<String> ingredientsHierarchy;

    @SerializedName("expiration_date")
    private String expirationDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLabels() {
        return labels;
    }

    public void setLabels(String labels) {
        this.labels = labels;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public ENutriments getNutriments() {
        return nutriments;
    }

    public void setNutriments(ENutriments nutriments) {
        this.nutriments = nutriments;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getStates() {
        return states;
    }

    public void setStates(String states) {
        this.states = states;
    }

    public String getCountries() {
        return countries;
    }

    public void setCountries(String countries) {
        this.countries = countries;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public List<EIngredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<EIngredient> ingredients) {
        this.ingredients = ingredients;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getBrands() {
        return brands;
    }

    public void setBrands(String brands) {
        this.brands = brands;
    }

    public String getAllergens() {
        return allergens;
    }

    public void setAllergens(String allergens) {
        this.allergens = allergens;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getNutritionDataPreparedPer() {
        return nutritionDataPreparedPer;
    }

    public void setNutritionDataPreparedPer(String nutritionDataPreparedPer) {
        this.nutritionDataPreparedPer = nutritionDataPreparedPer;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageThumbUrl() {
        return imageThumbUrl;
    }

    public void setImageThumbUrl(String imageThumbUrl) {
        this.imageThumbUrl = imageThumbUrl;
    }

    public String getImageSmallUrl() {
        return imageSmallUrl;
    }

    public void setImageSmallUrl(String imageSmallUrl) {
        this.imageSmallUrl = imageSmallUrl;
    }

    public String getImageFrontSmallUrl() {
        return imageFrontSmallUrl;
    }

    public void setImageFrontSmallUrl(String imageFrontSmallUrl) {
        this.imageFrontSmallUrl = imageFrontSmallUrl;
    }

    public String getImageFrontUrl() {
        return imageFrontUrl;
    }

    public void setImageFrontUrl(String imageFrontUrl) {
        this.imageFrontUrl = imageFrontUrl;
    }

    public String getIngredientsTextWithAllergensFr() {
        return ingredientsTextWithAllergensFr;
    }

    public void setIngredientsTextWithAllergensFr(String ingredientsTextWithAllergensFr) {
        this.ingredientsTextWithAllergensFr = ingredientsTextWithAllergensFr;
    }

    public String getImageIngredientsThumbUrl() {
        return imageIngredientsThumbUrl;
    }

    public void setImageIngredientsThumbUrl(String imageIngredientsThumbUrl) {
        this.imageIngredientsThumbUrl = imageIngredientsThumbUrl;
    }

    public String getImageNutritionSmallUrl() {
        return imageNutritionSmallUrl;
    }

    public void setImageNutritionSmallUrl(String imageNutritionSmallUrl) {
        this.imageNutritionSmallUrl = imageNutritionSmallUrl;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    public List<String> getCitiesTags() {
        return citiesTags;
    }

    public void setCitiesTags(List<String> citiesTags) {
        this.citiesTags = citiesTags;
    }

    public List<String> getAdditivesOldTags() {
        return additivesOldTags;
    }

    public void setAdditivesOldTags(List<String> additivesOldTags) {
        this.additivesOldTags = additivesOldTags;
    }

    public ESelectedImages getSelectedImages() {
        return selectedImages;
    }

    public void setSelectedImages(ESelectedImages selectedImages) {
        this.selectedImages = selectedImages;
    }

    public List<String> getManufacturingPlacesTags() {
        return manufacturingPlacesTags;
    }

    public void setManufacturingPlacesTags(List<String> manufacturingPlacesTags) {
        this.manufacturingPlacesTags = manufacturingPlacesTags;
    }

    public String getNutritionGrades() {
        return nutritionGrades;
    }

    public void setNutritionGrades(String nutritionGrades) {
        this.nutritionGrades = nutritionGrades;
    }

    public List<String> getVitaminsPrevTags() {
        return vitaminsPrevTags;
    }

    public void setVitaminsPrevTags(List<String> vitaminsPrevTags) {
        this.vitaminsPrevTags = vitaminsPrevTags;
    }

    public List<String> getDebugParamSortedLangs() {
        return debugParamSortedLangs;
    }

    public void setDebugParamSortedLangs(List<String> debugParamSortedLangs) {
        this.debugParamSortedLangs = debugParamSortedLangs;
    }

    public List<String> getCategoriesTags() {
        return categoriesTags;
    }

    public void setCategoriesTags(List<String> categoriesTags) {
        this.categoriesTags = categoriesTags;
    }

    public String getIngredientsTextWithAllergens() {
        return ingredientsTextWithAllergens;
    }

    public void setIngredientsTextWithAllergens(String ingredientsTextWithAllergens) {
        this.ingredientsTextWithAllergens = ingredientsTextWithAllergens;
    }

    public List<String> getIngredientsFromPalmOilTags() {
        return ingredientsFromPalmOilTags;
    }

    public void setIngredientsFromPalmOilTags(List<String> ingredientsFromPalmOilTags) {
        this.ingredientsFromPalmOilTags = ingredientsFromPalmOilTags;
    }

    public String getImageFrontThumbUrl() {
        return imageFrontThumbUrl;
    }

    public void setImageFrontThumbUrl(String imageFrontThumbUrl) {
        this.imageFrontThumbUrl = imageFrontThumbUrl;
    }

    public String getImageNutritionUrl() {
        return imageNutritionUrl;
    }

    public void setImageNutritionUrl(String imageNutritionUrl) {
        this.imageNutritionUrl = imageNutritionUrl;
    }

    public String getImageNutritionThumbUrl() {
        return imageNutritionThumbUrl;
    }

    public void setImageNutritionThumbUrl(String imageNutritionThumbUrl) {
        this.imageNutritionThumbUrl = imageNutritionThumbUrl;
    }

    public String getImageIngredientsUrl() {
        return imageIngredientsUrl;
    }

    public void setImageIngredientsUrl(String imageIngredientsUrl) {
        this.imageIngredientsUrl = imageIngredientsUrl;
    }

    public List<String> getIngredientsTags() {
        return ingredientsTags;
    }

    public void setIngredientsTags(List<String> ingredientsTags) {
        this.ingredientsTags = ingredientsTags;
    }

    public int getAdditivesPrevN() {
        return additivesPrevN;
    }

    public void setAdditivesPrevN(int additivesPrevN) {
        this.additivesPrevN = additivesPrevN;
    }

    public String getAdditivesPrev() {
        return additivesPrev;
    }

    public void setAdditivesPrev(String additivesPrev) {
        this.additivesPrev = additivesPrev;
    }

    public String getAdditives() {
        return additives;
    }

    public void setAdditives(String additives) {
        this.additives = additives;
    }

    public String getIngredientsN() {
        return ingredientsN;
    }

    public void setIngredientsN(String ingredientsN) {
        this.ingredientsN = ingredientsN;
    }

    public List<String> getNutritionGradesTags() {
        return nutritionGradesTags;
    }

    public void setNutritionGradesTags(List<String> nutritionGradesTags) {
        this.nutritionGradesTags = nutritionGradesTags;
    }

    public List<String> getPackagingTags() {
        return packagingTags;
    }

    public void setPackagingTags(List<String> packagingTags) {
        this.packagingTags = packagingTags;
    }

    public List<String> getCodesTags() {
        return codesTags;
    }

    public void setCodesTags(List<String> codesTags) {
        this.codesTags = codesTags;
    }

    public String getManufacturingPlaces() {
        return manufacturingPlaces;
    }

    public void setManufacturingPlaces(String manufacturingPlaces) {
        this.manufacturingPlaces = manufacturingPlaces;
    }

    public List<String> getIngredientsDebug() {
        return ingredientsDebug;
    }

    public void setIngredientsDebug(List<String> ingredientsDebug) {
        this.ingredientsDebug = ingredientsDebug;
    }

    public String getImageIngredientsSmallUrl() {
        return imageIngredientsSmallUrl;
    }

    public void setImageIngredientsSmallUrl(String imageIngredientsSmallUrl) {
        this.imageIngredientsSmallUrl = imageIngredientsSmallUrl;
    }

    public String getGenericName() {
        return genericName;
    }

    public void setGenericName(String genericName) {
        this.genericName = genericName;
    }

    public List<String> getQualityTags() {
        return qualityTags;
    }

    public void setQualityTags(List<String> qualityTags) {
        this.qualityTags = qualityTags;
    }

    public List<String> getAdditivesOriginalTags() {
        return additivesOriginalTags;
    }

    public void setAdditivesOriginalTags(List<String> additivesOriginalTags) {
        this.additivesOriginalTags = additivesOriginalTags;
    }

    public int getServingQuantity() {
        return servingQuantity;
    }

    public void setServingQuantity(int servingQuantity) {
        this.servingQuantity = servingQuantity;
    }

    public List<String> getBrandsTags() {
        return brandsTags;
    }

    public void setBrandsTags(List<String> brandsTags) {
        this.brandsTags = brandsTags;
    }

    public ENutrientLevels getNutrientLEvels() {
        return nutrientLEvels;
    }

    public void setNutrientLEvels(ENutrientLevels nutrientLEvels) {
        this.nutrientLEvels = nutrientLEvels;
    }

    public String getIngredientsText() {
        return ingredientsText;
    }

    public void setIngredientsText(String ingredientsText) {
        this.ingredientsText = ingredientsText;
    }

    public String getServingSize() {
        return servingSize;
    }

    public void setServingSize(String servingSize) {
        this.servingSize = servingSize;
    }

    public String getIngredientsTextFr() {
        return ingredientsTextFr;
    }

    public void setIngredientsTextFr(String ingredientsTextFr) {
        this.ingredientsTextFr = ingredientsTextFr;
    }

    public String getNutritionDataPer() {
        return nutritionDataPer;
    }

    public void setNutritionDataPer(String nutritionDataPer) {
        this.nutritionDataPer = nutritionDataPer;
    }

    public List<String> getIngredientsHierarchy() {
        return ingredientsHierarchy;
    }

    public void setIngredientsHierarchy(List<String> ingredientsHierarchy) {
        this.ingredientsHierarchy = ingredientsHierarchy;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public String toString() {
        return "EProduct{" +
                "id='" + id + '\'' +
                ", labels='" + labels + '\'' +
                ", code='" + code + '\'' +
                ", categories='" + categories + '\'' +
                ", nutriments=" + nutriments +
                ", link='" + link + '\'' +
                ", states='" + states + '\'' +
                ", countries='" + countries + '\'' +
                ", lang='" + lang + '\'' +
                ", ingredients=" + ingredients +
                ", quantity='" + quantity + '\'' +
                ", brands='" + brands + '\'' +
                ", allergens='" + allergens + '\'' +
                ", productQuantity=" + productQuantity +
                ", productName='" + productName + '\'' +
                ", nutritionDataPreparedPer='" + nutritionDataPreparedPer + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", imageThumbUrl='" + imageThumbUrl + '\'' +
                ", imageSmallUrl='" + imageSmallUrl + '\'' +
                ", imageFrontSmallUrl='" + imageFrontSmallUrl + '\'' +
                ", imageFrontUrl='" + imageFrontUrl + '\'' +
                ", ingredientsTextWithAllergensFr='" + ingredientsTextWithAllergensFr + '\'' +
                ", imageIngredientsThumbUrl='" + imageIngredientsThumbUrl + '\'' +
                ", imageNutritionSmallUrl='" + imageNutritionSmallUrl + '\'' +
                ", keywords=" + keywords +
                ", citiesTags=" + citiesTags +
                ", additivesOldTags=" + additivesOldTags +
                ", selectedImages=" + selectedImages +
                ", manufacturingPlacesTags=" + manufacturingPlacesTags +
                ", nutritionGrades='" + nutritionGrades + '\'' +
                ", vitaminsPrevTags=" + vitaminsPrevTags +
                ", debugParamSortedLangs=" + debugParamSortedLangs +
                ", categoriesTags=" + categoriesTags +
                ", ingredientsTextWithAllergens='" + ingredientsTextWithAllergens + '\'' +
                ", ingredientsFromPalmOilTags=" + ingredientsFromPalmOilTags +
                ", imageFrontThumbUrl='" + imageFrontThumbUrl + '\'' +
                ", imageNutritionUrl='" + imageNutritionUrl + '\'' +
                ", imageNutritionThumbUrl='" + imageNutritionThumbUrl + '\'' +
                ", imageIngredientsUrl='" + imageIngredientsUrl + '\'' +
                ", ingredientsTags=" + ingredientsTags +
                ", additivesPrevN=" + additivesPrevN +
                ", additivesPrev='" + additivesPrev + '\'' +
                ", additives='" + additives + '\'' +
                ", ingredientsN='" + ingredientsN + '\'' +
                ", nutritionGradesTags=" + nutritionGradesTags +
                ", packagingTags=" + packagingTags +
                ", codesTags=" + codesTags +
                ", manufacturingPlaces='" + manufacturingPlaces + '\'' +
                ", ingredientsDebug=" + ingredientsDebug +
                ", imageIngredientsSmallUrl='" + imageIngredientsSmallUrl + '\'' +
                ", genericName='" + genericName + '\'' +
                ", qualityTags=" + qualityTags +
                ", additivesOriginalTags=" + additivesOriginalTags +
                ", servingQuantity=" + servingQuantity +
                ", brandsTags=" + brandsTags +
                ", nutrientLEvels=" + nutrientLEvels +
                ", ingredientsText='" + ingredientsText + '\'' +
                ", servingSize='" + servingSize + '\'' +
                ", ingredientsTextFr='" + ingredientsTextFr + '\'' +
                ", nutritionDataPer='" + nutritionDataPer + '\'' +
                ", ingredientsHierarchy=" + ingredientsHierarchy +
                ", expirationDate='" + expirationDate + '\'' +
                '}';
    }
}

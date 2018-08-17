package com.toumi.foodfacts.data.provider.api.mapper;

import com.toumi.foodfacts.data.model.Nutriments;
import com.toumi.foodfacts.data.model.Product;
import com.toumi.foodfacts.data.provider.api.dto.EProductDetailsResponse;

/**
 * Created by Hatem Toumi on 8/17/18.
 */
public class ProductMapper {

    public static Product map(EProductDetailsResponse input) {
        if (input == null || input.getProduct() == null)
            return null;

        Product product = new Product();
        product.setCode(input.getCode());
        product.setName(input.getProduct().getProductName());
        product.setImageUrl(input.getProduct().getImageUrl());
        product.setGenericName(input.getProduct().getGenericName());
        product.setBrands(input.getProduct().getBrands());
        product.setCategories(input.getProduct().getCategories());
        product.setLink(input.getProduct().getLink());

        // Ingredients
        product.setIngredients(input.getProduct().getIngredientsText());
        if (input.getProduct().getSelectedImages() != null && input.getProduct().getSelectedImages().getIngedients() != null) {
            product.setIngredientsImageUrl(input.getProduct().getSelectedImages().getIngedients().getDisplay().getImageUrl());
        }

        // Nutriments
        Nutriments nutriments = new Nutriments();
        nutriments.setGrade(input.getProduct().getNutritionGrades());
        nutriments.setEnergy100gKj(input.getProduct().getNutriments().getEnergy100g());
        nutriments.setEnergy100gKcal(input.getProduct().getNutriments().getEnergyValue());
        if (input.getProduct().getSelectedImages() != null && input.getProduct().getSelectedImages().getNutrition() != null) {
            nutriments.setImageUrl(input.getProduct().getSelectedImages().getNutrition().getDisplay().getImageUrl());
        }
        product.setNutriments(nutriments);

        return product;
    }
}

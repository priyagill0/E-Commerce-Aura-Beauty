package com.example.backend.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.backend.model.Product;
import com.example.backend.model.ProductImage;
import com.example.backend.model.ProductType;
import com.example.backend.model.ProductVariant;
import com.example.backend.repository.ProductImageRepository;
import com.example.backend.repository.ProductRepository;
import com.example.backend.repository.ProductVariantRepository;

@Component
public class DataSeeder implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductVariantRepository variantRepository;

    @Autowired
    private ProductImageRepository imageRepository;

    @Override
    public void run(String... args) throws Exception {

        // Prevent duplicate seeding
        if (productRepository.count() > 0) {
            return;
        }

        // ============================================================
        // PRODUCT 1: Exfoliating Toner
        // ============================================================

        Product exfoliatingToner = new Product();
        exfoliatingToner.setProductId("85e49839-6a46-4324-af8a-e0fbe0387a9a");
        exfoliatingToner.setName("Exfoliating Toner");
        exfoliatingToner.setDescription("A gentle exfoliating toner (7% Glycolic Acid) that removes dead skin cells and promotes a radiant complexion.");
        exfoliatingToner.setProductType(ProductType.TONER);
        exfoliatingToner.setBrand("The Ordinary");
        productRepository.save(exfoliatingToner); // UUID auto-generated

        // Variants
        ProductVariant exfoliatingTonerVariant1 = new ProductVariant(exfoliatingToner, "240 mL", 12.99, 30, 0);
        exfoliatingTonerVariant1.setVariantId("b1c2d3e4-f5a6-7890-b1c2-d3e4f5a67890");
        variantRepository.save(exfoliatingTonerVariant1);

        ProductVariant exfoliatingTonerVariant2 = new ProductVariant(exfoliatingToner, "100 mL (Travel Size)", 6.99, 15, 1);
        exfoliatingTonerVariant2.setVariantId("c2d3e4f5-a678-90b1-c2d3-e4f5a67890b1");
        variantRepository.save(exfoliatingTonerVariant2);

        // images
        ProductImage exfoliatingTonerImage1 = new ProductImage(exfoliatingToner, exfoliatingTonerVariant1);
        exfoliatingTonerImage1.setImageId("11b2056a");
        exfoliatingTonerImage1.setImageUrl("/assets/products/"+ exfoliatingToner.getProductId()+ "/11b2056a.jpg");

        ProductImage exfoliatingTonerImage2 = new ProductImage(exfoliatingToner, exfoliatingTonerVariant1);
        exfoliatingTonerImage2.setImageId("4921635c");
        exfoliatingTonerImage2.setImageUrl("/assets/products/"+ exfoliatingToner.getProductId()+ "/4921635c.jpg");

        ProductImage exfoliatingTonerImage3 = new ProductImage(exfoliatingToner, exfoliatingTonerVariant1);
        exfoliatingTonerImage3.setImageId("c5ffe4dd");
        exfoliatingTonerImage3.setImageUrl("/assets/products/"+ exfoliatingToner.getProductId()+ "/c5ffe4dd.jpg");
        imageRepository.save(exfoliatingTonerImage1);
        imageRepository.save(exfoliatingTonerImage2);
        imageRepository.save(exfoliatingTonerImage3);


        // ============================================================
        // PRODUCT 2: Foaming Facial Cleanser
        // ============================================================

        Product foamingFaceWash = new Product();
        foamingFaceWash.setProductId("d4e5f6a7-b8c9-1234-d5e6-f7a8b9c01234");
        foamingFaceWash.setName("Foaming Facial Cleanser");
        foamingFaceWash.setDescription("A foaming face wash that is suitable for normal to oily skin types, effectively removing dirt and excess oil.");
        foamingFaceWash.setProductType(ProductType.FACE_WASH);
        foamingFaceWash.setBrand("CeraVe");
        productRepository.save(foamingFaceWash);

        // Variants
        ProductVariant foamingFaceWashVariant1 = new ProductVariant(foamingFaceWash, "355 mL", 10.99, 25, 0);
        foamingFaceWashVariant1.setVariantId("f1a2b3c4-d5e6-7890-f1a2-b3c4d5e67890");
        variantRepository.save(foamingFaceWashVariant1);

        ProductVariant foamingFaceWashVariant2 = new ProductVariant(foamingFaceWash, "100 mL Travel Size", 6.49, 10, 1);
        foamingFaceWashVariant2.setVariantId("a1b2c3d4-e5f6-7890-a1b2-c3d4e5f67890");
        variantRepository.save(foamingFaceWashVariant2);

        // images
        ProductImage foamingFaceWashImage1 = new ProductImage(foamingFaceWash, foamingFaceWashVariant1);
        foamingFaceWashImage1.setImageId("8f2bcf50");
        foamingFaceWashImage1.setImageUrl("/assets/products/"+ foamingFaceWash.getProductId()+ "/8f2bcf50.jpg");

        ProductImage foamingFaceWashImage2 = new ProductImage(foamingFaceWash, foamingFaceWashVariant1);
        foamingFaceWashImage2.setImageId("ed722469");
        foamingFaceWashImage2.setImageUrl("/assets/products/"+ foamingFaceWash.getProductId()+ "/ed722469.jpg");

        ProductImage foamingFaceWashImage3 = new ProductImage(foamingFaceWash, foamingFaceWashVariant1);
        foamingFaceWashImage3.setImageId("f049157c");
        foamingFaceWashImage3.setImageUrl("/assets/products/"+ foamingFaceWash.getProductId()+ "/f049157c.jpg");

        imageRepository.save(foamingFaceWashImage1);
        imageRepository.save(foamingFaceWashImage2);
        imageRepository.save(foamingFaceWashImage3);

        


    }
}

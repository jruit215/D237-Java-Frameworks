package com.example.demo.controllers;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.PartService;
import com.example.demo.service.ProductService;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;

/**
 *
 *
 *
 *
 */

@Controller
public class MainScreenControllerr {
   // private final PartRepository partRepository;
   // private final ProductRepository productRepository;'

    private PartService partService;
    private ProductService productService;

    private List<Part> theParts;
    private List<Product> theProducts;

 /*   public MainScreenControllerr(PartRepository partRepository, ProductRepository productRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
    }*/

    public MainScreenControllerr(PartService partService,ProductService productService){
        this.partService=partService;
        this.productService=productService;
    }
    @GetMapping("/mainscreen")
    public String listPartsandProducts(Model theModel, @Param("partKeyword") String partKeyword, @Param("productKeyword") String productKeyword) {
        //add to the sprig model
        List<Part> partList = partService.listAll(partKeyword);
        if (partList.size() >= 5) {
            theModel.addAttribute("parts", partList);
            theModel.addAttribute("partKeyword", partKeyword);
        } else {
            InhousePart newPart1 = new InhousePart();
            newPart1.setName("Espresso");
            newPart1.setInv(20);
            newPart1.setPrice(1.5);

            InhousePart newPart2 = new InhousePart();
            newPart2.setName("Vanilla Syrup");
            newPart2.setInv(3);
            newPart2.setPrice(0.5);

            InhousePart newPart3 = new InhousePart();
            newPart3.setName("Chai Mix");
            newPart3.setInv(4);
            newPart3.setPrice(1.0);

            InhousePart newPart4 = new InhousePart();
            newPart4.setName("Milk");
            newPart4.setInv(6);
            newPart4.setPrice(0.5);

            InhousePart newPart5 = new InhousePart();
            newPart5.setName("Black Tea");
            newPart5.setInv(10);
            newPart5.setPrice(1.0);

            InhousePart newPart6 = new InhousePart();
            newPart6.setName("Matcha Powder");
            newPart6.setInv(7);
            newPart6.setPrice(2.5);

            List<Part> newParts = new ArrayList<>();
            newParts.add(newPart1);
            newParts.add(newPart2);
            newParts.add(newPart3);
            newParts.add(newPart4);
            newParts.add(newPart5);
            newParts.add(newPart6);

            theModel.addAttribute("parts", newParts);
            theModel.addAttribute("partKeyword", partKeyword);
        }

        theModel.addAttribute("parts", partList);
        theModel.addAttribute("partKeyword", partKeyword);
        //    theModel.addAttribute("products",productService.findAll());
        List<Product> productList = productService.listAll(productKeyword);
        if (productList.size() >= 5) {
            theModel.addAttribute("products", productList);
            theModel.addAttribute("productKeyword", productKeyword);
            return "mainscreen";
        } else {
            Product newProduct = new Product();
            newProduct.setName("Cappuccino");
            newProduct.setInv(10);
            newProduct.setPrice(4.0);

            Product newProduct2 = new Product();
            newProduct2.setName("Chai Latte");
            newProduct2.setInv(10);
            newProduct2.setPrice(4.5);

            Product newProduct3 = new Product();
            newProduct3.setName("Matcha Latte");
            newProduct3.setInv(4);
            newProduct3.setPrice(5.25);

            Product newProduct4 = new Product();
            newProduct4.setName("London Fog");
            newProduct4.setInv(6);
            newProduct4.setPrice(3.5);

            Product newProduct5 = new Product();
            newProduct5.setName("Vanilla Latte");
            newProduct5.setInv(10);
            newProduct5.setPrice(3.75);

            List<Product> newProducts = new ArrayList<>();
            newProducts.add(newProduct);
            newProducts.add(newProduct2);
            newProducts.add(newProduct3);
            newProducts.add(newProduct4);
            newProducts.add(newProduct5);

            theModel.addAttribute("products", productList);
            theModel.addAttribute("productKeyword", productKeyword);
            return "mainscreen";
        }
    }

    @GetMapping("/about")
    public String aboutPage(){
        return "about";
    }

    @GetMapping("/buyPage")
    public String successOrFailure(@RequestParam("productID") long product) {
        if (productService.buyNow(product)) {
            return "success";
        } else {
            return "failure";
        }
    }

}

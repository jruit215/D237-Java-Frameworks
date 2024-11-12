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
            InhousePart newPart = new InhousePart();
            newPart.setName("Espresso");
            newPart.setInv(20);
            newPart.setPrice(1.5);
            newPart.setMax(15);
            newPart.setMin(2);

            InhousePart newPart2 = new InhousePart();
            newPart2.setName("Vanilla Syrup");
            newPart2.setInv(3);
            newPart2.setPrice(0.5);
            newPart.setMax(15);
            newPart.setMin(2);

            InhousePart newPart3 = new InhousePart();
            newPart3.setName("Milk");
            newPart3.setInv(6);
            newPart3.setPrice(0.5);
            newPart.setMax(15);
            newPart.setMin(2);

            InhousePart newPart4 = new InhousePart();
            newPart4.setName("Black Tea");
            newPart4.setInv(10);
            newPart4.setPrice(1.0);
            newPart.setMax(15);
            newPart.setMin(2);

            InhousePart newPart5 = new InhousePart();
            newPart5.setName("Matcha Powder");
            newPart5.setInv(7);
            newPart5.setPrice(2.5);
            newPart.setMax(15);
            newPart.setMin(2);

            List<Part> newParts = new ArrayList<>();
            newParts.add(newPart);
            newParts.add(newPart2);
            newParts.add(newPart3);
            newParts.add(newPart4);
            newParts.add(newPart5);

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
            newProduct2.setName("Americano");
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

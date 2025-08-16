package com.klu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    Repo r1;

    public String insertData(Product p) {
        r1.save(p);
        return "Insert success";
    }

    public List<Product> displayData() {
        return r1.findAll();
    }

    public String updateData(Product p) {
        if (r1.existsById(p.getId())) {
            r1.save(p);
            return "Update success";
        } else {
            return "Product not found";
        }
    }

    public boolean deleteData(int id) {
        if (r1.existsById(id)) {
            r1.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}

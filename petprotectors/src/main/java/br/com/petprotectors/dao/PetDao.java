package br.com.petprotectors.dao;

import br.com.petprotectors.model.Pet;
import br.com.petprotectors.servlet.config.ConnectionPoolConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PetDao {

    public void criarPet (Pet pet){
        String SQL = "INSERT INTO PET (NOME, IDADE, SEXO, ESPECIE, RACA, TUTOR) VALUES (?,?,?,?,?,?)";

        try {

            Connection connection = ConnectionPoolConfig.getConnection();

            System.out.println("success in database connection");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, pet.getNome());
            preparedStatement.setString(2, pet.getIdade());
            preparedStatement.setString(3, pet.getSexo());
            preparedStatement.setString(4, pet.getEspecie());
            preparedStatement.setString(5, pet.getRaca());
            preparedStatement.setInt(6, 1);
            preparedStatement.execute();


        } catch (Exception e){

            System.out.println("fail in database connection");

        }
    }

    public void deletePetByName(String petName){

        String SQL = "DELETE PET WHERE NAME = ?";

        try {

            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

            System.out.println("success in database connection");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, petName);
            preparedStatement.execute();

            System.out.println("success on delete car with id: " + petName);

            connection.close();

        } catch (Exception e) {

            System.out.println("fail in database connection");

        }
    }

    public List<Pet> findAllPets(){
        String SQL = "SELECT * FROM PET";
        try {

            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

            System.out.println("success in database connection");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            ResultSet resultSet = preparedStatement.executeQuery();

            List<Pet> pets = new ArrayList<>();

            while (resultSet.next()) {

                String petNome = resultSet.getString("name");
                String petTutor = resultSet.getString("tutor");
                String petIdade = resultSet.getString("idade");
                String petSexo = resultSet.getString("sexo");
                String petEspecie = resultSet.getString("especie");
                String petRaca = resultSet.getString("raca");
                String petId = resultSet.getString("idPet");

                Pet pet = new Pet(petNome, petTutor,petIdade, petSexo,petEspecie,petRaca, petId);

                pets.add(pet);

            }

            System.out.println("success in select * pet");

            connection.close();

            return pets;

        } catch (Exception e) {

            System.out.println("fail in database connection");

            return Collections.emptyList();
        }
    }


}

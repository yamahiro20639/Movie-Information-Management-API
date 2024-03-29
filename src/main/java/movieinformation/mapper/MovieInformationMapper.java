package movieinformation.mapper;

import movieinformation.entity.Movie;
import org.apache.ibatis.annotations.*;
import java.util.List;
import java.util.Optional;

@Mapper
public interface MovieInformationMapper {
    //GET
    @Select("SELECT * FROM movie_list ")
    List<Movie> findAll();

    @Select("SELECT * FROM movie_list WHERE id=#{id}")
    Optional<Movie> findById(int id);

    @Select("SELECT * FROM movie_list  WHERE name LIKE CONCAT('%',#{partOfMovieName}, '%')")
    List<Movie> findByMovieName(String partOfMovieName);

    //POST
    @Select("SELECT name FROM movie_list WHERE REPLACE(name,' ','') = #{name}")
    Optional<String> findByName(String name);

    @Insert("INSERT INTO movie_list (name,release_date,director_name,box_office) VALUES (#{name}, #{releaseDate},#{directorName},#{boxOffice})")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    void insert(Movie movie);

    //PATCH
    @Update("UPDATE movie_list SET name=#{name},release_date=#{releaseDate},director_name=#{directorName},box_office = #{boxOffice} WHERE id=#{id} ")
    void update(Movie movie);

    //DELETE
    @Delete("DELETE FROM movie_list WHERE id =#{id}")
    void delete(int id);
}

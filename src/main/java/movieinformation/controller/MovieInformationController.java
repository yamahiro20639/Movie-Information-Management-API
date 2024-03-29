package movieinformation.controller;

import movieinformation.Form.MovieRegistrationForm;
import movieinformation.Form.MovieUpdateForm;
import movieinformation.controller.Response.MovieDeleteResponse;
import movieinformation.controller.Response.MovieResponse;
import movieinformation.controller.Response.MovieUpdateResponse;
import movieinformation.entity.Movie;
import movieinformation.service.MovieInformationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class MovieInformationController {

    //フィールドインジェクション(非推奨)
    //@Autowired
    //private  MovieInformationService movieInformationService;

    //コンストラクタインジェクション(推奨)
    private final MovieInformationService movieInformationService;
    @Autowired
   public MovieInformationController(MovieInformationService movieInformationService) {
        this.movieInformationService = movieInformationService;
    }

    //GETの実装
    //全件取得の実装
    @GetMapping("/movies")
    public List<Movie> findAllMovies() {
        return movieInformationService.findAll();
    }

    //ID検索により該当データ取得+例外処理
    @GetMapping("/movies/{id}")
    public Movie findByMovieId(@PathVariable("id") int id) {
        return movieInformationService.findById(id);
    }

    //クエリ文字列を活用して映画名で検索
    @GetMapping("/movie")
    public List<Movie> findByMovieName(@RequestParam String partOfMovieName){
        return movieInformationService.findByMovieName(partOfMovieName);
    }

    //POST
    //映画を新規登録 Validated追加
    @PostMapping("/movies")
    public ResponseEntity<MovieResponse> insertMovie(@RequestBody @Valid MovieRegistrationForm movieRegistrationForm, UriComponentsBuilder uriBuilder) {
        Movie movie = movieInformationService.insert(movieRegistrationForm.convertToMovie());
        URI location = uriBuilder.path("/movie/{id}").buildAndExpand(movie.getId()).toUri();
        MovieResponse body = new MovieResponse("Movie registered");
        return ResponseEntity.created(location).body(body);
    }

    //PATCH
    //映画情報を更新登録 Validated追加
    @PatchMapping("/movies/{id}")
    public ResponseEntity<MovieUpdateResponse> updateMovie(@PathVariable("id") int id, @RequestBody @Valid MovieUpdateForm movieUpdateForm) {
        movieInformationService.update(movieUpdateForm.convertToMovie(id));
        MovieUpdateResponse movieUpdateResponse = new MovieUpdateResponse("Movie updated");
        return ResponseEntity.ok(movieUpdateResponse);
    }

    //DELETE
    //映画情報を削除登録
    @DeleteMapping("/movies/{id}")
    public ResponseEntity<MovieDeleteResponse> deleteMovie(@PathVariable("id") int id) {
        movieInformationService.delete(id);
        MovieDeleteResponse movieDeleteResponse = new MovieDeleteResponse("Movie deleted");
        return ResponseEntity.ok(movieDeleteResponse);
    }
}

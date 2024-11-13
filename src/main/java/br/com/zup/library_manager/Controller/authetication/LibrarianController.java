package br.com.zup.library_manager.Controller.authetication;

import br.com.zup.library_manager.Controller.authetication.dtos.LibrarianResponseDTO;
import br.com.zup.library_manager.Controller.authetication.dtos.LoginDTO;
import br.com.zup.library_manager.Service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class LibrarianController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LibrarianResponseDTO> login(@RequestBody LoginDTO loginDTO){

        String token = authService.login(loginDTO);
        LibrarianResponseDTO librarianResponseDto = new LibrarianResponseDTO();
        librarianResponseDto.setAccessToken(token);
        return new ResponseEntity<>(librarianResponseDto, HttpStatus.OK);
    }
}

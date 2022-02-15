package codegym.validate_song.controller;


import codegym.validate_song.dto.SongDto;
import codegym.validate_song.model.Song;
import codegym.validate_song.service.SongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Optional;


@Controller
public class SongController {

    @Autowired
    private SongService songService;

    @GetMapping("/list-song")
    public ModelAndView showSongList(@PageableDefault(size = 3) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("/home");
        Page<Song> songList = songService.findAll(pageable);
        modelAndView.addObject("songList", songList);
        return modelAndView;
    }

    @GetMapping("/create-song")
    public ModelAndView showCreate(){
        ModelAndView modelAndView = new ModelAndView("/create");
        SongDto songDto = new SongDto();
        modelAndView.addObject("songDto", songDto);
        return modelAndView;
    }

    @PostMapping("/create-song")
    public ModelAndView createSong(@Valid SongDto songDto,
                                     BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("/create");
        if (bindingResult.hasFieldErrors()){
            return modelAndView;
        }else {
            Song song = new Song();
            BeanUtils.copyProperties(songDto, song);
            songService.Save(song);
            modelAndView.addObject("songDto", songDto);
            modelAndView.addObject("message", "Create new song successfully!");
        }
        return modelAndView;
    }

    @GetMapping("/update-song/{id}")
    public ModelAndView showUpdate(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("/update");
        Optional<Song> song = songService.findById(id);
        SongDto songDto = new SongDto();
        BeanUtils.copyProperties(song.get(), songDto);
        modelAndView.addObject("songDto", songDto);
        return modelAndView;
    }

    @PostMapping("/update-song")
    public ModelAndView update(@Valid @ModelAttribute("songDto") SongDto songDto,
                                   BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("/update");
        if (bindingResult.hasFieldErrors()){
            return modelAndView;
        }else {
            Song song = new Song();
            BeanUtils.copyProperties(songDto, song);
            songService.Save(song);
            modelAndView.addObject("songDto", songDto);
            modelAndView.addObject("message", "update new song successfully!");
        }
        return modelAndView;
    }


}

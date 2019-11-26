import { FETCH_MOVIES, NEW_MOVIE, FETCH_DESCR } from "./types";
import axios from "axios";

export const fetchMovies = () => dispatch => {
  console.log("In acion");
  fetch("http://localhost:8080/movies")
    .then(res => res.json())
    .then(data => dispatch({ type: FETCH_MOVIES, payload: data }));
};

export const postMovie = (title, director, year, description) => dispatch => {
  console.log("postMovie");
  axios
    .post("http://localhost:8080/movies", {
      title: title,
      director: director,
      year: year,
      description: description
    })
    .then(res => {
      dispatch({ type: NEW_MOVIE, payload: {} });
    });
};

export const fetchDescription = id => dispatch => {
  console.log("in fetch description");
  fetch(`http://localhost:8080/movies/${id}`)
    .then(res => res.json())
    .then(data => dispatch({ type: FETCH_DESCR, payload: data }));
};

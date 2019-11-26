import {
  FETCH_MOVIES,
  NEW_MOVIE,
  FETCH_DESCR,
  TOGGLE_SHOFORM
} from "../actions/types";

const initialState = {
  movies: [],
  movie: { description: "" },
  showForm: true
};

export default function(state = initialState, action) {
  switch (action.type) {
    case FETCH_MOVIES:
      console.log("in Reducer fetch");
      return { ...state, movies: action.payload };
    case NEW_MOVIE:
      console.log("in Reducer post");
      return state;
    case FETCH_DESCR:
      console.log("in Reducer fetch description");
      return { ...state, movie: action.payload };
    default:
      return state;
  }
}

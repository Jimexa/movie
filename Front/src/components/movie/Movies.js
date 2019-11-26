import React, { Component } from "react";
import PropTypes from "prop-types";
import { connect } from "react-redux";
import { fetchMovies, fetchDescription } from "../../actions/postActions";
import { Row, Container, Col } from "reactstrap";
import moment from "moment";
import "./Movies.css";

let movieItems = [];

class Movies extends Component {
  componentWillMount() {
    this.props.fetchMovies();
  }

  movieSelect = id => {
    this.props.fetchDescription(id);
  };

  render() {
    movieItems = this.props.movies
      .filter(movie => movie.title.includes(this.props.filter))
      .map(movie => (
        <Row
          key={movie.id}
          className="movieLI"
          onClick={() => this.movieSelect(movie.id)}
        >
          <a style={{ textAlign: "right" }}>{movie.title}</a>
          <a style={{ textAlign: "left" }}>
            {moment(movie.year).format("YYYY-MM-DD")}
          </a>
        </Row>
      ));
    return (
      <Container fluid={true}>
        <Row>
          <Col
            sm="6"
            style={{
              borderColor: "#dddddd",
              borderRightStyle: "solid",
              borderTopStyle: "solid"
            }}
          >
            {movieItems}
          </Col>
          <Col style={{ borderColor: "#dddddd", borderTopStyle: "solid" }}>
            {this.props.movie.description}
          </Col>
        </Row>
      </Container>
    );
  }
}

Movies.propTypes = {
  fetchMovies: PropTypes.func.isRequired,
  movies: PropTypes.array.isRequired
};

const mapStateToProps = state => ({
  movies: state.movies.movies,
  movie: state.movies.movie
});

export default connect(mapStateToProps, { fetchMovies, fetchDescription })(
  Movies
);

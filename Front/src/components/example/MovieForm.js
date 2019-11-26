import React, { Component } from "react";
import { Button, Form, FormGroup, Label, Input } from "reactstrap";
import { connect } from "react-redux";
import { fetchMovies, postMovie } from "../../actions/postActions";
import axios from "axios";
import moment from "moment";

class MovieForm extends Component {
  state = { description: "", title: "", director: "", year: "" };

  onChangeTitle = value => {
    this.setState({ title: value });
    console.log(value, "---------------", this.state.title);
  };

  onChangeDirector = value => {
    this.setState({ director: value });
  };

  onChangeDate = value => {
    this.setState({ year: value });
  };

  onChangeDescription = value => {
    this.setState({ description: value });
  };

  onSubmit = (title, director, year, description) => {
    this.props.postMovie(title, director, year, description);
  };

  myPost = () => {
    axios.post("http://localhost:8080/movies", {
      title: this.state.title,
      director: this.state.director,
      year: moment(this.state.year),
      description: this.state.description
    });
  };

  render() {
    this.props.fetchMovies();

    return (
      <div style={{ margin: 10 }}>
        <Form>
          <h5 style={{ marginLeft: 10 }}>New Movie</h5>
          <FormGroup>
            <Label for="exampleTitle">Movie Title</Label>
            <Input
              type="text"
              name="title"
              id="exampleTitle"
              onChange={e => this.onChangeTitle(`${e.target.value}`)}
            />
          </FormGroup>
          <FormGroup>
            <Label for="exampleDirector">Director</Label>
            <Input
              type="text"
              name="text"
              id="exampleDirector"
              onChange={e => this.onChangeDirector(`${e.target.value}`)}
            />
          </FormGroup>
          <FormGroup>
            <Label for="exampleDate">Year</Label>
            <Input
              type="date"
              name="date"
              id="exampleDate"
              onChange={e => this.onChangeDate(`${e.target.value}`)}
            />
          </FormGroup>
          <FormGroup>
            <Label for="exampleText">Description</Label>
            <Input
              type="textarea"
              name="text"
              id="exampleText"
              onChange={e => this.onChangeDescription(`${e.target.value}`)}
            />
          </FormGroup>
          <Button
            onClick={() => {
              if (
                this.state.title !== "" &&
                this.state.year !== "" &&
                this.state.description !== "" &&
                this.state.director !== ""
              ) {
                this.myPost();
                this.props.fetchMovies();
                setTimeout(() => {
                  this.props.hide();
                }, 1000);
              } else {
                alert("please fill all ther fields");
              }
            }}
          >
            Add Movie
          </Button>
          <Button
            onClick={() => {
              this.props.hide();
            }}
            className="float-right"
          >
            Return
          </Button>
        </Form>
      </div>
    );
  }
}

const mapStateToProps = state => ({
  movie: state.movies.movie
});

export default connect(mapStateToProps, {
  fetchMovies,
  postMovie
})(MovieForm);

import React, { Component } from "react";
import { Row, Button, Input, Spinner } from "reactstrap";
import { connect } from "react-redux";
import { fetchMovies } from "../../actions/postActions";

import Movies from "../movie/Movies";
import MovieForm from "../example/MovieForm";
import "./MainApp.css";

class MainApp extends Component {
  state = { showForm: false, loading: true, search: "" };

  componentWillMount() {
    this.props.fetchMovies();
  }

  componentDidMount() {
    fetch("http://localhost:8080/movies")
      .then(res => res.json())
      .then(res => {
        if (res.length !== 0) {
          this.setState({ showForm: false });
        }
        this.setState({ loading: false });
      });
  }

  onChange = value => {
    this.setState({ search: value });
  };

  show = () => {
    this.setState({ showForm: true });
  };

  hide = () => {
    this.setState({ showForm: false });
  };

  render() {
    if (this.state.loading) {
      return (
        <div className={"spinnerContainer"}>
          <Spinner />
        </div>
      );
    }
    return (
      <React.Fragment>
        <Row className={"search"}>
          <Button
            outline
            color="secondary"
            style={{
              marginLeft: 15
            }}
            onClick={this.show}
            disabled={this.state.showForm}
          >
            ADD MOVIE
          </Button>
          <Input
            style={{ marginLeft: 10, background: "white", flex: 1 }}
            placeholder={"Type to search"}
            disabled={this.state.showForm}
            onChange={e => {
              this.onChange(`${e.target.value}`);
            }}
            value={this.state.search}
          />
        </Row>
        {this.state.showForm ? (
          <MovieForm hide={this.hide} />
        ) : (
          <Movies filter={this.state.search} />
        )}
      </React.Fragment>
    );
  }
}

const mapStateToProps = state => ({
  movies: state.movies.movies
});

export default connect(mapStateToProps, { fetchMovies })(MainApp);

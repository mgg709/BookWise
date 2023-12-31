import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    {
      path: '/about',
      name: 'about',
      // route level code-splitting
      // this generates a separate chunk (About.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import('../views/AboutView.vue')
    },
    {
      path: "/selling",
      name: "selling",
      component: () => import('../views/SellingView.vue')
    },
    {
      path: "/login",
      name: "login",
      component: () => import('../views/Login.view.vue')
    },
    {
      path: "/signup",
      name: "signup",
      component: () => import('../views/SignUp.view.vue')
    },
    {
      path: "/book/:title",
      name: "book",
      component: () => import('../views/BookView.vue')
    },
    {
      path: "/profile",
      name: "profile",
      component: () => import('../views/Profile.view.vue')
    },
    {
      path: "/recommendation",
      name: "recommendation",
      component: () => import('../views/RecommendationView.vue'),
    },
    {
      path: "/solution",
      name: "solution",
      component: () => import('../views/SolutionView.vue')
    },
    {
      path: "/review",
      name: "review",
      component: () => import('../views/Profile.review.view.vue')
    },
    {
      path: "/favourite",
      name: "favourite",
      component: () => import('../views/Profile.favourite.view.vue')
    },
    {
      path: "/result",
      name: "result",
      component: () => import('../views/BookListView.vue')
    },
    {
      path: "/write/:nombre",
      name: "write",
      component: () => import('../views/WriteReview.view.vue')
    }
  ]
})

export default router
